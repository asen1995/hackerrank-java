import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class prototypeclass {

    public static void main(String[] args) {
        ShapeCache shapeCache = new ShapeCache();

        shapeCache.getShape("160000000");
        shapeCache.getShape("160000000");
        shapeCache.getShape("160000000");


    }
}

class Shape implements Cloneable{

    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

class ShapeCache {

    private static Map<String, Shape> shapeMap = new HashMap<String, Shape>();


    public Shape getShape(String key){

        if(shapeMap.containsKey(key)) {
            System.out.println("Returning shape with existing key: " + key);
            return (Shape) shapeMap.get(key).clone();
        }

        System.out.println("Creating new shape with key: " + key);
        final int i = Integer.parseInt(key);

        Shape shape = new Shape();
        for(int j = 0; j < i; j++){
            shape.getList().add(j);
        }
        shapeMap.put(key, shape);

        return shape;
    }
}
