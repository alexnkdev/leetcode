class NumberContainers {

    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, TreeSet<Integer>> numberToIndeces;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndeces = new HashMap<>();
    }
    
    public void change(int index, int number) {
        Integer existingNumber = indexToNumber.get(index);
        if (existingNumber != null) {
            numberToIndeces.get(existingNumber).remove(index);
        }

        if (numberToIndeces.get(number) == null) {
            numberToIndeces.put(number, new TreeSet<>());
        }
        numberToIndeces.get(number).add(index);
        indexToNumber.put(index, number);
    }
    
    public int find(int number) {
        if (!numberToIndeces.containsKey(number)
        || numberToIndeces.get(number).isEmpty()) {
            return -1;
        }
        Integer min = numberToIndeces.get(number).first();
        return min != null ? min : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */