package Base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.*;

public class LogListener implements TestWatcher, BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeAllCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.addAttachment("log", stopCatch());
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        MultithreadedConsoleOutputCatcher.startCatch();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Test Log", type = "text/plain")
    public String stopCatch() {
        String result = MultithreadedConsoleOutputCatcher.getContent();
        MultithreadedConsoleOutputCatcher.stopCatch();
        return result;
    }
}