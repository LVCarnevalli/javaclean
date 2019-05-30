package br.community.javaclean;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = {"src/test/resources/features"},
    glue = {"classpath:br.community.component.test.stepdefinitions"},
    strict = true)
public class RunCucumberTest {}
