package br.community.javaclean;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = {"src/test/resources/features"},
    glue = {"io.github.osvaldjr.stepdefinitions"},
    strict = true)
public class RunCucumberTest {}
