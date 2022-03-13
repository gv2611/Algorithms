import java.util.ArrayList;

class Interval
{
  int start, end;
  Interval(int start, int end)
  {
    this.end=end;
    this.start=start;
  }
}

public class MergeIntervals {

  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    printIntervals(intervals);

    for(int i=0;i<intervals.size()-1;i++)
    {
      if(intervals.get(i).end < newInterval.start)
        continue;
      if(intervals.get(i).start>=newInterval.start && intervals.get(i).end <newInterval.end)
      {
        return null;
      }
    }

return null;
  }

  public static void printIntervals(ArrayList<Interval> intervals)
  {
    for(int i=0; i<intervals.size();i++)
    {
      System.out.println("["+intervals.get(i).start+","+intervals.get(i).end+"]");
    }


  }

  public static void main(String[] args)
  {
    MergeIntervals merge = new MergeIntervals();
    ArrayList<Interval> intervals= new  ArrayList<Interval>();
    Interval interval=new Interval(1,2);
    Interval interval2=new Interval(3,5);
    Interval interval3=new Interval(6,7);
    Interval interval4=new Interval(8,10);
    Interval interval5=new Interval(12,16);

    intervals.add(interval);
    intervals.add(interval2);
    intervals.add(interval3);
    intervals.add(interval4);
    intervals.add(interval5);

    ArrayList<Interval> output = merge.insert(intervals, new Interval(4,9));
    //merge.insert(intervals, new Interval(4,9));


  }

  }
