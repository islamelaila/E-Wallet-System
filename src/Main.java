import Service.ApplicationService;
import Service.impl.ApplicationServiceImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationService applicationService = new ApplicationServiceImpl();
        applicationService.startApplication();
    }
}