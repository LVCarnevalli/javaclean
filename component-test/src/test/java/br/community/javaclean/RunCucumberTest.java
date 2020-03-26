package br.community.javaclean;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.osvaldjr.core.EasyCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = {"src/test/resources/features"},
    glue = {EasyCucumberRunner.GLUE_EASY_CUCUMBER, "br.community.javaclean.steps"},
    tags = {"not @Ignore"},
    strict = true)
public class RunCucumberTest extends EasyCucumberRunner {}
