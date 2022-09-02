import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Rate {

    private float rate;
    private int min;
    private int max;

}