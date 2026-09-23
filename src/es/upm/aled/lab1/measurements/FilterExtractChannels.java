package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	private int[] validChannels;

	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		this.validChannels = validChannels;
		
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement [] originales = eeg.getMeasurements();
		Measurement [] filtrados = new Measurement [originales.length];
		for (int i = 0; i < originales.length; i++) {
			float[] nuevosCanales = new float[validChannels.length];
			for (int j = 0; j < validChannels.length; j++) {
				int canalDeseado = validChannels[j];
				nuevosCanales[j] = originales[i].getChannel(canalDeseado);
			}
			filtrados[i] = new Measurement(nuevosCanales);
			}
		return new EEGModel(filtrados);
		
	}

}
