package pl.sabre.zadania;

// TODO: Given two cells on the standard chess board, determine whether they have the same color or not.
// TODO: e.g. for cell1 = "A1" and cell2 = "C3" the output should be chessBoardSameCellColor(cell1, cell2) = true
public class Task1 {
    private static boolean chessBoardSameCellColor(String cell1, String cell2) {
        return isCellWhite(cell1) == isCellWhite(cell2);
    }

    private static boolean isCellWhite(String cell) {
        int x = cell.charAt(0) - 97;
        int y = Integer.valueOf(cell.substring(1, 2));
        return (x + y) % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(chessBoardSameCellColor("A1", "C3"));
    }
}
