package web.service;

import web.model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private static List<Car> carList;
    static {
        carList = new ArrayList<>();
        carList.add(new Car("VAZ", "Black", 33));
        carList.add(new Car("GAZ", "White", 53));
        carList.add(new Car("Volga", "Blue", 25));
        carList.add(new Car("Kamaz", "Orange", 8));
        carList.add(new Car("Moskvitch", "Petsunda", 41));
    }
    public static List<Car> getCarList() {
        return carList;
    }

  public static List<Car> carRequest(String count) {

    if (count == null) {
      return getCarList();
    }
    int countInt = Integer.parseInt(count);
    List<Car> result = new ArrayList<>(getCarList());
    if (countInt >= result.size()) {
      return result;
    } else {
      if (countInt > 0) {
        return result.subList(0, countInt);
      }
    }
    return null;
  }
}
