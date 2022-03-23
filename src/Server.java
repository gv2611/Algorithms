import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

// Represents a request.
interface Request {}

// Represents a string response. Can be created from a StepResult. Also, provides static method for
// creating a response for an invalid request.
class Response {
  private final String r;
  Response(String r) {
    this.r = r;
  }

  @Override
  public String toString() {
    return r;
  }

  // Creates and returns a response from a StepResult.
  static Response createFrom(StepResult r) {
    return new Response(r.toString());
  }

  // Creates and returns a response for an invalid request.
  static Response getInvalidResponse() {
    return new Response("");
  }
}

// Represents result of a single Step.
class StepResult {
  // Combines multiple `StepResult`s into a single Result.
  static StepResult combine(ArrayList<StepResult> results) {
    // Implement dependent combination logic goes here...
    return new StepResult();
  }
}

// Represents a single step of execution on the server.
interface Step {
  // Executes a step on a given request and returns the execution result of the step in the form of
  // StepResult.
  public StepResult execute(Request request) throws Exception;
}

// Represents a step that is executed sequentially. A single sequential step blocks execution till
// it's finished executing.
interface SequentialStep {
  public StepResult execute(Request request);
}

// Represents result of a sequential step.
class SequentialStepResult extends StepResult {}

// A sequential step that performs validation.
abstract class ValidationStep implements SequentialStep {
  @Override
  public StepResult execute(Request request) {
    if (validate(request)) {
      return ValidationResult.VALID;
    }
    return ValidationResult.INVALID;
  }

  // Validates a request and returns if it's a valid request or not.
  abstract public boolean validate(Request request);
}

// Represents result of a validation step.
class ValidationResult extends StepResult {
  public static ValidationResult VALID = new ValidationResult(true);
  public static ValidationResult INVALID = new ValidationResult(false);

  private final boolean isValid;

  private ValidationResult(boolean isValid) {
    this.isValid = isValid;
  }

  // Returns whether the request is valid or not.
  boolean IsValid() {
    return isValid;
  }
}

// Represents a step that is executed in parallel.
class ParallelStep implements Step, Callable<ParallelStepResult> {
  @Override
  public ParallelStepResult call() throws Exception {
    // Do long running task here like network calls, etc.
    return new ParallelStepResult();
  }

  @Override
  public StepResult execute(Request request) throws Exception {
    return call();
  }
}

// Result of a parallel step.
class ParallelStepResult extends StepResult {}

// Concrete classes for validations.
class Step1 extends ValidationStep {
  @Override
  public boolean validate(Request request) {
    // Does validation of the request.
    return true;
  }
}
class Step2 extends ValidationStep {
  @Override
  public boolean validate(Request request) {
    // Does validation of the request.
    return true;
  }
}
class Step3 extends ValidationStep {
  @Override
  public boolean validate(Request request) {
    // Does validation of the request.
    return true;
  }
}

class Step4 implements SequentialStep {
  @Override
  public StepResult execute(Request request) {
    // Do step 4
    return new SequentialStepResult();
  }
}

class Step5 extends ParallelStep {
  @Override
  public ParallelStepResult call() throws Exception {
    // Run step 5 logic
    return new ParallelStepResult();
  }
}
class Step6 extends ParallelStep {
  @Override
  public ParallelStepResult call() throws Exception {
    // Run step 6 logic
    return new ParallelStepResult();
  }
}

// Combines results of other steps and is a sequential step.
class Step7 implements SequentialStep {
  private final ArrayList<StepResult> results;

  Step7(ArrayList<StepResult> results) {
    this.results = results;
  }

  @Override
  public StepResult execute(Request request) {
    // Combine results and create a step result and return it.
    return StepResult.combine(results);
  }
}

public class Server {
  public static void main(String[] args) {
    // Start server here...
  }

  Response handleRequest(Request request) throws ExecutionException, InterruptedException {
    // Validation steps.
    Step1 s1 = new Step1();
    Step2 s2 = new Step2();
    Step3 s3 = new Step3();
    if (!s1.validate(request) || !s2.validate(request) || !s3.validate(request)) {
      // Request is invalid.
      return Response.getInvalidResponse();
    }

    // Step-4
    Step4 s4 = new Step4();
    StepResult r4 = s4.execute(request);

    // Step-5 and Step-6 in parallel
    Step5 s5 = new Step5();
    Step6 s6 = new Step6();

    // Create a executor and submit parallel steps.
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    Future<ParallelStepResult> f5 = executor.submit(s5);
    Future<ParallelStepResult> f6 = executor.submit(s6);

    // Block on future results.
    StepResult r5 = f5.get();
    StepResult r6 = f6.get();

    // Step-7
    ArrayList<StepResult> results = new ArrayList<>(Arrays.asList(r4, r5, r6));
    Step7 s7 = new Step7(results);
    StepResult r7 = s7.execute(request);

    return Response.createFrom(r7);
  }
}

//Step interface -> execute method
//execute method request leta tha
//
//sequential step interface
//parallel step  abstract class (implements step and  callable ) - > call method
//
//
//
//validationStep extends sequentialStep
//validate method : request leke true false return karta hai
//
//    step 4  class: any sequential step implements sequential step
//
//validationStep3 wll be implemented by validator 1-2-3 class
//
//parallel step implement karke step 5-6




