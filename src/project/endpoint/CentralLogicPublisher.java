package project.endpoint;
import javax.xml.ws.Endpoint;
import project.ws.CentralLogicImpl;
//Endpoint publisher
public class CentralLogicPublisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:6900/ws/hello", new CentralLogicImpl());
    }
}