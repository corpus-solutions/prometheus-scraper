package prometheus.text;

import prometheus.types.Metric;

/**
 * This represents a sample as found in the text data. This may or may not represent
 * a full metric. In the case of a counter or gauge, it will represent the full metric.
 * In the case of a summary or histogram, this only represents one quantile or one bucket
 * in a full summary or histogram metric. For those two cases, additional processing needs to
 * be made to combine multiple TextMetric objects into a single SummaryMetric or HistogramMetric.
 */
public class TextSample extends Metric {

    public static class Builder extends Metric.Builder<Builder> {
        private String value;
        private String line;
        private String timestamp;

        public TextSample build() {
            return new TextSample(this);
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }
        
        public Builder setTimestamp(String value) {
            this.timestamp = value;
            return this;
        }

        public Builder setLine(String line) {
            this.line = line;
            return this;
        }
    }

    private final String value;
    private final String line;
    private final String timestamp;

    public TextSample(Builder builder) {
        super(builder);
        this.value = builder.value;
        this.line = builder.line;
        this.timestamp = builder.timestamp;
    }

    public String getValue() {
        return value;
    }
    
    public String getTimestamp() {
		return timestamp;
	}

    /**
     * This is the line of text in the text data where this sample came from.
     * This can be used for debugging purposes so you know what the sample
     * looked like before being parsed.
     *
     * @return the sample text line
     */
    public String getLine() {
        return line;
    }
}
