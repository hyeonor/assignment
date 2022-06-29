class Bus {
  int busNum;
  int speed = 0; // 속도
  int fare = 1000; //요금
  int fare_sum; // 탑승 승객 전체 요금
  int passenger; //탑승 승객
  int amount_of_oil = 100; // 초기 주유량
  int max_passenger = 30; // 최대 승객 수
  String state = "운행중"; // 운행상태

  
  public Bus(int num) {
    this.busNum = num;
  }

  public void takeBus(int passenger_num) {
    max_passenger -= passenger_num;
    if(this.max_passenger > 0 && state.equals("운행중")){
      this.fare_sum = fare * passenger_num;
      System.out.println("탑승 승객 수 : " + passenger_num + "\n잔여 승객 수 : " + this.max_passenger + "\n요금확인 : " + fare_sum + "\n");
    }
    else{
      this.max_passenger += passenger_num;
      if (state.equals("차고지행"))
        System.out.println("버스 차고에 있습니다.");
      else{
        System.out.println("최대 승객 수 초과");
      }
    }
  }
  
  public void speedBus(int speed_num) {
    if(this.state.equals("운행중")) this.speed += speed_num ;
  }
  
  public void stateBus(String state_srting) {
    this.state = state_srting ;
    if (state_srting.equals("차고지행"))
      this.max_passenger = 30;
  }
  
  public void oilBus(int oil) {
    this.amount_of_oil += oil;
    
    if (oil < 0){
      if(amount_of_oil < 10){
        this.state = "차고지행";
        this.max_passenger = 30;
        System.out.println("주유량 확인해주세요");
        System.out.println("주유량 : " + amount_of_oil + "\n상태 : " + state + "\n");
      }
      else
        System.out.println("주유량 : " + amount_of_oil + "\n");    
    }
    else{
      System.out.println("상태 : " + state  +"\n주유량 : " + amount_of_oil + "\n" );
    }
  }
  
   public int getBusNum() {
      return busNum;
   }

   public int getfare() {
      return fare_sum;
   }

   public int getPassenger() {
      return passenger;
   }
  
   public int getoil() {
      return amount_of_oil;
   }

   public int getspeed() {
      return speed;
   }

   public String getstate() {
      return state;
   }
  
  public void showInfo() {
      System.out.println("버스 번호: " + this.getBusNum() + " 주유량: " + getoil() + " 상태: " + getstate());
   }
}



class Taxi {
  int subwayNum;
  int passenger;
  int addDest; // 초과거리
  int fare = 3000;//기본 요금
  int fare_sum; // 택시 요금
  int accrue_fare; //택시 누적 요금
  int amount_of_oil = 100; // 초기 주유량
  int max_passenger = 4; // 최대 승객 수
  String state = "일반"; // 운행상태

  public Taxi(int num) {
    this.subwayNum = num;
  }

  public void fareTaxi(int passenger_num, String dest, int dest_distance) {
    max_passenger -= passenger_num;
    if(this.max_passenger > 0 && state.equals("일반")){
      addDest = dest_distance - 1; //초과 거리 계산
      fare_sum = fare + addDest*1000;  //요금계산
      accrue_fare += fare_sum; //누적 요금 계산
      state = "운행중";
      System.out.println("탑승 승객 수 : " + passenger_num + "\n잔여 승객 수 : " + this.max_passenger + "\n기본 요금확인 : " + fare + "\n목적지 : " + dest + "\n목적지까지 거리: " + dest_distance +"km"+ "\n지불할 요금: " + fare_sum + "\n상태: " + state + "\n");
    }
    else{
      this.max_passenger += passenger_num;
      System.out.println("최대 승객 수 초과");
    }
  }

  public void oilTaxi(int oil) {
    this.amount_of_oil += oil;
    
    if (oil < 0){
      if(amount_of_oil < 10){
        this.max_passenger = 4;
        state = "운행불가";
        System.out.println("주유량 확인해주세요");
        System.out.println("주유량 : " + amount_of_oil + "\n상태 : " + state + "\n누적요금 : " + accrue_fare + "\n");
      }    
    }
    else{
      System.out.println("상태 : " + state  +"\n주유량 : " + amount_of_oil + "\n" );
    }
  }

  public void payment(){
    state = "일반";
    max_passenger = 4;
    System.out.println("주유량 : " + amount_of_oil + "\n누적요금 : " + fare_sum  + "\n");
  }
  
  public void stateTaxi(String state_srting) {
    
  }

  public int getsubwayNum() {
    return subwayNum;
  }

  public int getPassenger() {
    return passenger;
  }

  public int getoil() {
      return amount_of_oil;
  }

  public String getstate() {
      return state;
  }
  
  public void showInfo() {
    System.out.println("택시 번호: "+this.getsubwayNum()+" 주유량: "+this.getoil()+" 상태: "+this.getstate());
  }
}

class Main {
  public static void main(String[] args) {
    Bus bus1 = new Bus(100);
    Bus bus2 = new Bus(200);
    Taxi Taxi1 = new Taxi(100);
    Taxi Taxi2 = new Taxi(200);

    System.out.println("버스 번호 다른지 확인");
    bus1.showInfo();
    bus2.showInfo();

    System.out.println("\n승객 +2");
    bus1.takeBus(2);

    System.out.println("주유량 -50");
    bus1.oilBus(-50);

    System.out.println("상태변경(차고지행)");
    bus1.stateBus("차고지행");

    System.out.println("\n주유량 +10");
    bus1.oilBus(10);

    System.out.println("상태변경(운행중)");
    bus1.stateBus("운행중");

    System.out.println("\n승객 45");
    bus1.takeBus(45);

    System.out.println("\n승객 5");
    bus1.takeBus(5);

    System.out.println("\n주유량 -55");
    bus1.oilBus(-55);

    System.out.println("\n\n택시 번호 다른지 확인");
    Taxi1.showInfo();
    Taxi2.showInfo();

    System.out.println("\n(입력값)승객 +2 목적지 = 서울역 목적직까지 거리 = 2km");
    Taxi1.fareTaxi(2, "서울역", 2);

    System.out.println("\n주유량 -80");
    Taxi1.oilTaxi(-80);

    System.out.println("\n요금 결제");
    Taxi1.payment();

    System.out.println("\n승객 5");
    Taxi1.fareTaxi(5, "서울역", 2);

    System.out.println("\n(입력값)승객 +3 목적지 = 구로디지털단지역 목적직까지 거리 = 12km");
    Taxi1.fareTaxi(3, "구로디지털단지역", 12);

    System.out.println("\n주유량 -20");
    Taxi1.oilTaxi(-20);
  }
}