import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationParser {

public static void makeFarsh(){
    System.out.println("animal recycled");
}
    public void parseAnnotations(Class[] animalList) {

        for (int i = 0; i < animalList.length; i++) {

            Annotation[] animalAnnotations = animalList[i].getDeclaredAnnotations();

            for (Annotation a : animalAnnotations) {
                if (a instanceof isBloxastiy) {
                    isBloxastiy isBloxastiy = (isBloxastiy) a;
                    System.out.println(animalList[i].getName()+ " has flea : " + isBloxastiy.value());
                    if(isBloxastiy.value()==true){

                    }

                }
            }

            Field[] field = animalList[i].getDeclaredFields();

            for (Field f : field) {
                Annotation[] annotations = f.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Color) {
                        Color myAnnotation = (Color) annotation;
                        System.out.println("color: " + myAnnotation.color());
                        if (myAnnotation.color()=="black"){

                        }
                    }
                }
            }
        }
    }
}