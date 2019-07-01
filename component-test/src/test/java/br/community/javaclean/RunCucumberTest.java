package br.community.javaclean;

import static io.github.osvaldjr.EasyCucumberRunner.GLUE_EASY_CUCUMBER;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.osvaldjr.EasyCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
    features = {"src/test/resources/features"},
    glue = {GLUE_EASY_CUCUMBER},
    strict = true)
public class RunCucumberTest extends EasyCucumberRunner {}
