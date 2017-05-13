package test3;

public class CalDistance {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    CalDistance obj=new CalDistance();
    /*obj.distance(38.898556, -77.037852, 38.897147, -77.043934);*/
        
        System.out.println(obj.distance(28.898556, -27.037852, 28.897147, -27.043934) + " Kilometers\n");
          
    }   
    public double distance(double lat1, double lon1, double lat2, double lon2) {


          double theta = lon1 - lon2;
          double dist = Math.sin(lat1* Math.PI / 180.0) * Math.sin(lat2* Math.PI / 180.0) + Math.cos(lat1* Math.PI / 180.0) *
                  Math.cos(lat2* Math.PI / 180.0) * Math.cos(theta* Math.PI / 180.0);
          dist = Math.acos(dist);
          dist = dist* 180.0 / Math.PI;
          dist = (dist * 60 * 1.1515)* 1.609344;
          return (dist);
        }
  

    }