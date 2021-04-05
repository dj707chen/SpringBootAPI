package payroll;

import com.intuit.karate.junit5.Karate;

public class PayrollRunnerTest {
    @Karate.Test
    Karate testQuotes() {
        return Karate.run("Employee").relativeTo(getClass());
    }
}
