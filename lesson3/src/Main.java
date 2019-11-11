public class Main {
    public static void main(String[] args) {

        AnnotationParser parser = new AnnotationParser();

        Class[] animalList = new Class[]{Cat.class, Cat2.class, Cat3.class, Dog.class, Dog2.class};

        parser.parseAnnotations(animalList);

//        Field [] catField = cat2.getDeclaredFields();

//        for(Field field : cat2.getDeclaredFields()){
//                        Annotation[] annotations = field.getDeclaredAnnotations();
//
//            for (Annotation a: annotations             ) {
//                System.out.println(a);
//        }

//        for (Field f:catField
//             ) {
//            System.out.println(f);
//        }

//        Class cat2 = Cat.class;
//        Annotation[] annotations2 =cat2.getDeclaredAnnotations();
//
//        Annotation[] annotations = cat2.getAnnotations();
//        for (Annotation a: annotations2             ) {
//            System.out.println(a);
    }
}

