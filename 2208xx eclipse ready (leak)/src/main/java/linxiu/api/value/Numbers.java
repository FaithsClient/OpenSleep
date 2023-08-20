package linxiu.api.value;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class Numbers<T extends Number>
extends Value<T> {
    private String name;
    public T min;
    public T max;
    public T inc;
    public String tag;

    private final boolean integer;

    private String suffix = "";

    public Numbers(String name, T value, T min, T max, T inc) {
        super(name);
        this.setValue(value);
        this.min = min;
        this.max = max;
        this.inc = inc;
        this.integer = false;
        this.suffix = "";
    }

    public Numbers(String name, T value, T min, T max, T inc, String suffix) {
        super(name);
        this.setValue(value);
        this.min = min;
        this.max = max;
        this.inc = inc;
        this.integer = false;
        this.suffix = suffix;
    }

	public Numbers(String displayName, String name, T value, T min, T max, T inc) {
		super(displayName, name);
		this.setValue(value);
		this.min = min;
		this.max = max;
		this.inc = inc;
		this.integer = false;
	}

	@Override
    public T getValue() {
        return super.getValue();
    }


    @Override
    public void setValue(T value) {
        super.setValue(value);
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(getValue());
    }

    @Override
    public void fromJson(JsonElement element) {
        if(element.isJsonPrimitive())
            setValue((T) element.getAsNumber());
    }

    public T getMinimum() {
        return this.min;
    }

    public T getMaximum() {
        return this.max;
    }

    public void setIncrement(T inc) {
        this.inc = inc;
    }

    public T getIncrement() {
        return this.inc;
    }

    public String getId() {
        return this.name;
    }

    public String getSuffix() {
        return suffix;
    }

	public boolean isInteger() {
		return this.integer;
	}
}

