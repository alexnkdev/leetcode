
class Solution {
  
  public int nearestDrone(int[][] drones, int[] target) {
    
    int minDroneIndex = -1;
    int minDistance = -1;

    for (int i = 0; i < drones.length; i++) {
      int xi = drones[i][0];
      int yi = drones[i][1];
      int rangei = drones[i][2];

      int tx = target[0];
      int ty = target[1];

      int dist = Math.abs(tx - xi) + Math.abs(ty - yi);
      if (dist <= rangei) {
        if (minDistance == -1 || minDistance > dist) {
          minDistance = dist;
          minDroneIndex = i;
        }
      }
    }


    return minDroneIndex;

  }

}
