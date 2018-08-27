package Cucumber_Execution;

import cucumber.api.PickleStepTestStep;

public class Thread_Local {

        private static final ThreadLocal<PickleStepTestStep> threadStepDefMatch = new InheritableThreadLocal<PickleStepTestStep>();

        private Thread_Local() {
        }

        public static PickleStepTestStep get() {
            return threadStepDefMatch.get();
        }

        public static void set(PickleStepTestStep match) {
            threadStepDefMatch.set(match);
        }

        public static void remove() {
            threadStepDefMatch.remove();
        }
    }
