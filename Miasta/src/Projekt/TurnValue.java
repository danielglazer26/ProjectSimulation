package Projekt;

 class TurnValue {

    private int  city_upgrade;

    public void checkCityUpgrade (CitiesEvolution city){

        System.out.println(city.getCity_table().get(0).getFortune());
       if(city_upgrade>0) {
           city.getCity_table().get(0).addLevel();
       }
    }

}
