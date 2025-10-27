package com.example.explorecalijpa.projections;

import com.example.explorecalijpa.model.Tour;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="showSummary", types = {Tour .class})
public interface ShowSummary {
    String getTitle();
    String getPrice();
    String getDuration();
}
