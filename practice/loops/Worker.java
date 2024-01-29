package practice.loops;

public class Worker {
    /**
     * Looks for any categories in the String given and prints them to standard out.
     * @param input A string with categories defined like 'category:nameOfCategory' inside it.
     */
    public static void printCategories(String input){
        String categoryTag = "category:";
        if(input == null || !input.contains(categoryTag)){
            System.out.println("No categories found in the given input.");
            return;
        }
        String mutableInput = input;
        // 1. Find indexes of 'category:'
        while(mutableInput.contains(categoryTag)){
            int startOfCategory = mutableInput.indexOf(categoryTag);
            if(startOfCategory == -1){
                break; // Can't find any more categories.
            }
            else{
                // 2. For each category found
                String substringWithCategory = mutableInput.substring(startOfCategory);
                // 3. Take substring until end of word (space, dot, comma or end of string)
                int startIndexOfCategoryName = 9; // To skip 'category:'
                int endIndexOfCategoryName = findIndexOfCategoryWordEnd(substringWithCategory, startIndexOfCategoryName);
                // 4. Print category.
                String category = substringWithCategory.substring(startIndexOfCategoryName, endIndexOfCategoryName);
                System.out.println(category);
                // 5. Update mutable string, so we don't get the same category.
                mutableInput = substringWithCategory.substring((categoryTag.length()-1));
            }
        }
    }

    /**
     * Goes through the {@param substringWithCategory} until it finds the end of the category word.
     * Example: Given "category:categoryName" it should find the index of the 'e' from the Name part.
     * @param substringWithCategory Example: "category:somecategory of blah, blah" or "category:testing."
     * @param startIndexOfCategoryName The index of the first character after "category:"
     * @return The index of the last character in a category word.
     */
    private static int findIndexOfCategoryWordEnd(String substringWithCategory, int startIndexOfCategoryName) {
        int charCounter = 1;
        while(substringWithCategory.charAt(startIndexOfCategoryName + charCounter) != ' '
                && substringWithCategory.charAt(startIndexOfCategoryName + charCounter) != '.'){
            int indexOfWordEnd = startIndexOfCategoryName + charCounter;
            if((startIndexOfCategoryName + charCounter) == substringWithCategory.length()){
                return indexOfWordEnd-1; // We've reached the end of the string.
            }
            charCounter++;
        }
        return startIndexOfCategoryName + charCounter;
    }
}
