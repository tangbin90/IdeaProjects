package mypackage;


public class test{
    public static void main(String args[]){
        HelloWorldService helloWorldImplService=new HelloWorldService();
        HelloWorld helloWorld= helloWorldImplService.getHelloWorldPort();
        String returnStr=  helloWorld.sayHelloWorldFrom("先知后觉");
        System.out.println(returnStr);
    }

}
