package practice.loops;

public class LoopsPractice {
    public static void main(String[] args){
        String input = "We have a large inventory of things in our warehouse falling in " +
                "the category:apparel and the slightly " +
                "more in demand category:makeup along with wit the category:furniture.";
        Worker.printCategories(input);
        String forLoopInput = "sfdfewencsoidfhsjdf";
        Worker.printInputInReverseOrder(forLoopInput);
        Worker.printEvenNumbers(9);
    }
}
