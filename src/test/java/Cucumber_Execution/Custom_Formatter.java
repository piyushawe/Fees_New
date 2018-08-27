package Cucumber_Execution;

import cucumber.api.PickleStepTestStep;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepStarted;
import cucumber.api.formatter.Formatter;

public class Custom_Formatter implements Formatter {


        public Custom_Formatter() {}

        private EventHandler<TestStepStarted> stepStartedHandler = new EventHandler<TestStepStarted>() {
            @Override
            public void receive(TestStepStarted event) {
                handleTestStepStarted(event);
            }
        };

        @Override
        public void setEventPublisher(EventPublisher publisher) {
            publisher.registerHandlerFor(TestStepStarted.class, stepStartedHandler);
        }

        private void handleTestStepStarted(TestStepStarted event) {
            if(event.testStep instanceof PickleStepTestStep) {
                Thread_Local.set((PickleStepTestStep)event.testStep);
            }

        }
    }

