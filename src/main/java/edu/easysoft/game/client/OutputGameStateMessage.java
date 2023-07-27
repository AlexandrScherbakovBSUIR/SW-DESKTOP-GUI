package edu.easysoft.game.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@Getter
@AllArgsConstructor
public class OutputGameStateMessage {
    @JsonProperty("location")
    private Point location;
    @JsonProperty("trophy")
    private int trophy;
}
