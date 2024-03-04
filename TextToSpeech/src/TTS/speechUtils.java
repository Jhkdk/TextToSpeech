package TTS;

import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class speechUtils {
    private static Synthesizer synth;
   
    public static void speak(String input) {
        if (synth == null) {
            initSynthesizer();
        }

        try {
            synth.speakPlainText(input, null);
            synth.waitEngineState(synth.QUEUE_EMPTY);
        } catch (IllegalArgumentException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static void initSynthesizer() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        try {
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            synth = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

            synth.allocate();
            synth.resume();
        } catch (EngineException | AudioException | EngineStateError e) {
            e.printStackTrace();
        }
    }

    public static void closeSynthesizer() throws EngineException, EngineStateError {
        if (synth != null) {
            synth.deallocate();
            synth = null;
        }
    }
}
