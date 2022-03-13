import java.util.HashSet;

public class IsValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    int row= board.length;
    int column= board[0].length;
    for(int i=0;i<row;i++)
    {
      for (int j=0;j<column;j++)
      {
        if(!isValidConfig(board, i, j))
          return false;
      }
    }
    return true;

  }

  public boolean isValidConfig(char[][]board, int row, int column)
  {
    return isValidRow(board,row) && isValidColumn(board,column) && isValidBox(board,row-row%3, column-column%3);
  }

  public boolean isValidRow(char board[][],int row)
  {
    HashSet<Character> values= new HashSet<>();
    for(int i=0;i<9;i++)
    {
      if(values.contains(board[row][i]))
        return false;
      if (board[row][i] != '.')
        values.add(board[row][i]);
    }
    return true;
  }

  public boolean isValidColumn(char board[][],int column )
  {
    HashSet<Character> values= new HashSet<>();
    for(int i=0;i<9;i++)
    {
      if(values.contains(board[i][column]))
        return false;
      if (board[i][column] != '.')
        values.add(board[i][column]);
    }
    return true;
  }

  public boolean isValidBox(char board[][],int startRow, int startColumn )
  {
    HashSet<Character> values= new HashSet<>();
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<3;j++)
      {
        char current = board[startRow+i][startColumn+j];
        if(values.contains(current))
          return false;
        if(current!='.')
          values.add(current);
      }
    }
    return true;
  }


  public static void main(String[] args)
  {
    IsValidSudoku sudoku = new IsValidSudoku();
    char[][] board = new char[][] {
        { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
    };

    System.out.println(sudoku.isValidSudoku(board));
  }
}
