import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class AnnotationParser {
    //    List <String> namesOfCats = new ArrayList<>();
    public int getRandom() {
        return ThreadLocalRandom.current().nextInt(2) + 1;
    }

    public void parseAnnotations(Class[] animalList) {

        for (int i = 0; i < animalList.length; i++) {

            Annotation[] animalAnnotations = animalList[i].getDeclaredAnnotations();

            for (Annotation classAnnotation : animalAnnotations) {
                if (classAnnotation instanceof isBloxastiy) {

                    isBloxastiy isBloxastiyAnnotation = (isBloxastiy) classAnnotation;
                    Field[] field = animalList[i].getDeclaredFields();

                    for (Field f : field) {

                        Annotation[] fieldAnnotation = f.getDeclaredAnnotations();

                        for (Annotation annotation : fieldAnnotation) {
                            if (annotation instanceof Color) {

                                Color colorAnnotation = (Color) annotation;

                                try {
                                    if (!(animalList[i].newInstance() instanceof Dogs) &&
                                            isBloxastiyAnnotation.value() == false &&
                                            (getRandom() == 1 && colorAnnotation.color().equals("black"))) {

                                        System.out.println(animalList[i].getName() + " will be farsh");

//                                        namesOfCats.add(animalList[i].getName());
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}