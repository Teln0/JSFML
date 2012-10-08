package org.jsfml.audio;

/**
 * Specialized {@link SoundRecorder} which stores captured audio data into a {@link SoundBuffer}.
 */
public class SoundBufferRecorder extends SoundRecorder {
    private SoundBuffer soundBuffer;

    /**
     * Creates a new sound buffer recorder.
     */
    public SoundBufferRecorder() {
        super();
        soundBuffer = new SoundBuffer(nativeGetBuffer());
    }

    @Override
    protected native long nativeCreate();

    @Override
    protected void nativeSetExPtr() {
        //TODO Make SoundRecorder tree use the ExPtr system.
    }

    @Override
    protected native void nativeDelete();

    private native long nativeGetBuffer();

    /**
     * Gets the sound buffer containing the captured audio data.
     *
     * @return The sound buffer containing the captured audio data.
     */
    public ConstSoundBuffer getBuffer() {
        return soundBuffer;
    }

    @Override
    public native void start(int sampleRate);

    @Override
    public native void stop();

    @Override
    public native int getSampleRate();
}
