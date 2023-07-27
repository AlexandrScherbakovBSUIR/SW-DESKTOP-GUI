package edu.easysoft.game.playground;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
public class PlayGroundWalker {
    @JsonProperty("location")
    private Point location;
    @JsonProperty("trophy")
    private int trophy;

    public PlayGroundWalker(Point location){
        this.location=location;

    }

    public void increaseTrophy(int cellValue){
        trophy = trophy + cellValue;
        System.out.println(trophy);

    }


}
