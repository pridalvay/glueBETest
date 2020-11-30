package com.example.ageverifier;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.ageverifier"},
        tags = {"@ageverifierbackend"}
)
public class TestRunner {
}
