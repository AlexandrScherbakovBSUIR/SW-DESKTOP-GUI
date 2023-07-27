package edu.easysoft.game.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.easysoft.game.playground.PlayGroundWalker;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;


@Setter
@Getter
public class GameStateMessage {
    @JsonProperty("playGroundWalker")
    private PlayGroundWalker playGroundWalker;


}
