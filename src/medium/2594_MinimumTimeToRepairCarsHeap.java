class Solution {
  public long repairCars(int[] ranks, int cars) {
    
    PriorityQueue<Mechanic> queue = new PriorityQueue<Mechanic>((m1, m2) -> {
      return Long.compare(m1.time_to_finish, m2.time_to_finish);
    });

    for (int i = 0; i < ranks.length; i++) {
      queue.add(new Mechanic(ranks[i], 1, ranks[i] * 1));
    }

    long total_cars = 0;
    while (true) {
      Mechanic nextMechanic = queue.poll();
      long time = nextMechanic.time_to_finish;
      total_cars++;
      if (total_cars >= cars) {
        return time;
      }
      queue.add(new Mechanic(nextMechanic.rank, nextMechanic.cars_repaired + 1,
        (long) (nextMechanic.cars_repaired + 1) * (nextMechanic.cars_repaired + 1) * nextMechanic.rank));
    }

  }

  static class Mechanic {
    int rank;
    int cars_repaired;
    long time_to_finish;

    public Mechanic(int rank, int cars_repaired, long time_to_finish) {
        this.rank = rank;
        this.cars_repaired = cars_repaired;
        this.time_to_finish = time_to_finish;
    }
  }
}
