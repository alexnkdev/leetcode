class StockSpanner {

  Stack<Item> mst = new Stack<Item>();

  public StockSpanner() {

  }

  public int next(int price) {
    int span = 1;
    while (!mst.isEmpty() && price >= mst.peek().price) {
      span += mst.pop().span;
    }
    mst.push(new Item(price, span));
    return span;
  }

  class Item {
    int price;
    int span;
    public Item(int price, int span) {
      this.price = price;
      this.span = span;
    }

    public String toString() {
      return "[" + price + ", " + span + "]";
    }
  }

}
