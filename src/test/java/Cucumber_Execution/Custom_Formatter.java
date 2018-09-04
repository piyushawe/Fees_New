package Cucumber_Execution;

import Log4jpackage.LoggerClass;
import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.event.*;
import cucumber.api.formatter.Formatter;


public class Custom_Formatter implements Formatter {
    private static Result result;
    static Boolean failed=false;
    static Boolean passed=false;
    static Boolean skip=false;

        public Custom_Formatter() {}

        private EventHandler<TestStepStarted> stepStartedHandler = new EventHandler<TestStepStarted>(){
            @Override
            public void receive(TestStepStarted event) {
                handleTestStepStarted(event);
                //stepnames=Thread_Local.get().getStepText();

            }
        };
    private final EventHandler<TestCaseFinished> testCaseFinishedHandler = new EventHandler<TestCaseFinished>() {
        @Override
        public void receive(TestCaseFinished event) {
            receiveResult(event.result);
        }
    };
    void receiveResult(Result result) {
        this.result = result;
    }
    public static void getStatus()
    {
        switch (result.getStatus())
        {
            case FAILED: failed=true;
            break;
            case PASSED: passed=true;
            break;
            case SKIPPED: skip=true;
            break;
            default:
                LoggerClass.log_info.debug("Nothing to set");
        }
    }
        @Override
        public void setEventPublisher(EventPublisher publisher) {
            publisher.registerHandlerFor(TestCaseFinished.class, testCaseFinishedHandler);
            publisher.registerHandlerFor(TestStepStarted.class, stepStartedHandler);

        }

        private void handleTestStepStarted(TestStepStarted event) {
            if(event.testStep instanceof PickleStepTestStep) {
                Thread_Local.set((PickleStepTestStep)event.testStep);
            }

        }
    }

