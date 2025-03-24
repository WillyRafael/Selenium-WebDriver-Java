package dev.rafael.automation.pratice.selenium.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class RegisterUser extends BasePage {

    // Locators
    private By nameFirstPageSignUp = By.xpath("/html/body/section/div/div/div[3]/div/form/input[2]");
    private By emailFirstPageSignUp = By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]");
    private By emailFirstPageSignIn = By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]");
    private By passFirstPageSignIn = By.xpath("/html/body/section/div/div/div[1]/div/form/input[3]");
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("id_gender2");
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.xpath("//*[@id=\"password\"]");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By newsletter = By.id("newsletter");
    private By optin = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");
    private By btnSignUp = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private By btnSignIn = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By btnLogout = By.cssSelector("a[href='/logout']");
    private By btnDeleteAccount = By.cssSelector("a[href='/delete_account']");
    private By btnContinue = By.xpath("//a[text()='Continue']");
    private By accountCreatedMessage = By.xpath("//b[text()='Account Created!']");
    private By msgSignIn = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By msgSignUpAlreadyExist = By.xpath("//p[text()='Email Address already exist!']");

    public void login(String userEmail, String password) {
        try {
            type(userEmail, getEmailFirstPageSignIn());
            type(password, getPassFirstPageSignIn());
            actionMoveToElementClickPerform(getBtnSignIn());
            Thread.sleep(2000);
            Assertions.assertFalse(isDisplayed(getMsgSignIn()));
        } catch (Exception ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void signUp(String userName, String userEmail, HashMap<By, String> data) {
        try {
            type(userName, getNameFirstPageSignUp());
            type(userEmail, getEmailFirstPageSignUp());
            actionMoveToElementClickPerform(getBtnSignUp());
            Thread.sleep(2000);

            if (isDisplayed(getMsgSignUpAlreadyExist())) {
                login(userEmail, "password123");
                deleteUser();
                visit("https://www.automationexercise.com/signup");
                Thread.sleep(2000);

                type(userName, getNameFirstPageSignUp());
                type(userEmail, getEmailFirstPageSignUp());
                actionMoveToElementClickPerform(getBtnSignUp());

                Thread.sleep(2000);
                fillData(data);

                clickCreateAccount();
                Thread.sleep(2000);

                getSucessMsgOnPageSignUp();
                click(getBtnContinue());

                logoutUser();
            } else {
                fillData(data);
                clickCreateAccount();
                Thread.sleep(2000);

                getSucessMsgOnPageSignUp();
                click(getBtnContinue());

                logoutUser();
            }
        } catch (InterruptedException ex) {
        }
    }

    public void deleteUser() {
        try {
            Thread.sleep(2000);
            if (isDisplayed(getBtnDeleteAccount())) {
                super.actionMoveToElementClickPerform(getBtnDeleteAccount());
            } else {
                System.out.println("Delete Button not found!");
                Thread.sleep(2000);
            }
        } catch (InterruptedException ex) {
        }
    }

    public void logoutUser() {
        try {
            Thread.sleep(2000);
            if (isDisplayed(getBtnLogout())) {
                super.actionMoveToElementClickPerform(getBtnLogout());
            } else {
                System.out.println("Logout Button not found!");
                Thread.sleep(2000);
            }
        } catch (InterruptedException ex) {
        }
    }

    public String getTitlePage() {
        return super.getText(By.tagName("h2"));
    }

    public void getSucessMsgOnPageSignUp() {
        try {
            System.out.println(getText(getAccountCreatedMessage()));
            Thread.sleep(5000);
            Assertions.assertEquals("ACCOUNT CREATED!", getText(getAccountCreatedMessage()));
        } catch (InterruptedException ex) {
            Logger.getLogger(RegisterUser.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            super.click(getTitleMr());
        } else if (title.equalsIgnoreCase("Mrs")) {
            super.click(getTitleMrs());
        }
    }

    public void fillName(String userName) {
        super.type(userName, getName());
    }

    public void fillEmail(String userEmail) {
        super.type(userEmail, getEmail());
    }

    public void fillPassword(String userPassword) {
        super.type(userPassword, getPassword());
    }

    public void selectDateOfBirth(String day, String month, String year) {
        super.selectByValue(getDays(), day);
        super.selectByValue(getMonths(), month);
        super.selectByValue(getYears(), year);
    }

    public void subscribeNewsletter() {
        super.click(getNewsletter());
    }

    public void receiveSpecialOffers() {
        super.click(getOptin());
    }

    public void fillFirstName(String userFirstName) {
        super.type(userFirstName, getFirstName());
    }

    public void fillLastName(String userLastName) {
        super.type(userLastName, getLastName());
    }

    public void fillCompany(String userCompany) {
        super.type(userCompany, getCompany());
    }

    public void fillAddress1(String userAddress1) {
        super.type(userAddress1, getAddress1());
    }

    public void fillAddress2(String userAddress2) {
        super.type(userAddress2, getAddress2());
    }

    public void selectCountry(String userCountry) {
        super.selectByValue(getCountry(), userCountry);
    }

    public void fillState(String userState) {
        super.type(userState, getState());
    }

    public void fillCity(String userCity) {
        super.type(userCity, getCity());
    }

    public void fillZipcode(String userZipcode) {
        super.type(userZipcode, getZipcode());
    }

    public void fillMobileNumber(String userMobileNumber) {
        super.type(userMobileNumber, getMobileNumber());
    }

    public void clickCreateAccount() {
        try {
            Thread.sleep(2000);
            super.movePageAndClick(getCreateAccountButton());
        } catch (InterruptedException ex) {
            Logger.getLogger(RegisterUser.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillData(HashMap<By, String> data) {
        selectTitle(data.get(titleMr));
        fillPassword(data.get(password));
        fillFirstName(data.get(firstName));
        fillLastName(data.get(lastName));
        fillCompany(data.get(company));
        fillAddress1(data.get(address1));
        fillAddress2(data.get(address2));
        fillState(data.get(state));
        fillCity(data.get(city));
        fillZipcode(data.get(zipcode));
        fillMobileNumber(data.get(mobileNumber));

        selectCountry(data.get(country));
        selectDateOfBirth(data.get(days), data.get(months), data.get(years));

        if (data.get(optin).equals("Y")) {
            receiveSpecialOffers();
        }
        if (data.get(titleMr).equals("Y")) {
            selectTitle("Mr");
        }
        if (data.get(titleMrs).equals("Y")) {
            selectTitle("Mrs");
        }
        if (data.get(newsletter).equals("Y")) {
            subscribeNewsletter();
        }
    }

    public By getNameFirstPageSignUp() {
        return nameFirstPageSignUp;
    }

    public void setNameFirstPageSignUp(By nameFirstPageSignUp) {
        this.nameFirstPageSignUp = nameFirstPageSignUp;
    }

    public By getEmailFirstPageSignUp() {
        return emailFirstPageSignUp;
    }

    public void setEmailFirstPageSignUp(By emailFirstPageSignUp) {
        this.emailFirstPageSignUp = emailFirstPageSignUp;
    }

    public By getEmailFirstPageSignIn() {
        return emailFirstPageSignIn;
    }

    public void setEmailFirstPageSignIn(By emailFirstPageSignIn) {
        this.emailFirstPageSignIn = emailFirstPageSignIn;
    }

    public By getPassFirstPageSignIn() {
        return passFirstPageSignIn;
    }

    public void setPassFirstPageSignIn(By passFirstPageSignIn) {
        this.passFirstPageSignIn = passFirstPageSignIn;
    }

    public By getTitleMr() {
        return titleMr;
    }

    public void setTitleMr(By titleMr) {
        this.titleMr = titleMr;
    }

    public By getTitleMrs() {
        return titleMrs;
    }

    public void setTitleMrs(By titleMrs) {
        this.titleMrs = titleMrs;
    }

    public By getName() {
        return name;
    }

    public void setName(By name) {
        this.name = name;
    }

    public By getEmail() {
        return email;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public By getPassword() {
        return password;
    }

    public void setPassword(By password) {
        this.password = password;
    }

    public By getDays() {
        return days;
    }

    public void setDays(By days) {
        this.days = days;
    }

    public By getMonths() {
        return months;
    }

    public void setMonths(By months) {
        this.months = months;
    }

    public By getYears() {
        return years;
    }

    public void setYears(By years) {
        this.years = years;
    }

    public By getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(By newsletter) {
        this.newsletter = newsletter;
    }

    public By getOptin() {
        return optin;
    }

    public void setOptin(By optin) {
        this.optin = optin;
    }

    public By getFirstName() {
        return firstName;
    }

    public void setFirstName(By firstName) {
        this.firstName = firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public void setLastName(By lastName) {
        this.lastName = lastName;
    }

    public By getCompany() {
        return company;
    }

    public void setCompany(By company) {
        this.company = company;
    }

    public By getAddress1() {
        return address1;
    }

    public void setAddress1(By address1) {
        this.address1 = address1;
    }

    public By getAddress2() {
        return address2;
    }

    public void setAddress2(By address2) {
        this.address2 = address2;
    }

    public By getCountry() {
        return country;
    }

    public void setCountry(By country) {
        this.country = country;
    }

    public By getState() {
        return state;
    }

    public void setState(By state) {
        this.state = state;
    }

    public By getCity() {
        return city;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public By getZipcode() {
        return zipcode;
    }

    public void setZipcode(By zipcode) {
        this.zipcode = zipcode;
    }

    public By getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(By mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public By getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(By createAccountButton) {
        this.createAccountButton = createAccountButton;
    }

    public By getBtnSignUp() {
        return btnSignUp;
    }

    public void setBtnSignUp(By btnSignUp) {
        this.btnSignUp = btnSignUp;
    }

    public By getBtnSignIn() {
        return btnSignIn;
    }

    public void setBtnSignIn(By btnSignIn) {
        this.btnSignIn = btnSignIn;
    }

    public By getBtnLogout() {
        return btnLogout;
    }

    public void setBtnLogout(By btnLogout) {
        this.btnLogout = btnLogout;
    }

    public By getBtnDeleteAccount() {
        return btnDeleteAccount;
    }

    public void setBtnDeleteAccount(By btnDeleteAccount) {
        this.btnDeleteAccount = btnDeleteAccount;
    }

    public By getAccountCreatedMessage() {
        return accountCreatedMessage;
    }

    public void setAccountCreatedMessage(By accountCreatedMessage) {
        this.accountCreatedMessage = accountCreatedMessage;
    }

    public By getMsgSignIn() {
        return msgSignIn;
    }

    public void setMsgSignIn(By msgSignIn) {
        this.msgSignIn = msgSignIn;
    }

    public By getMsgSignUpAlreadyExist() {
        return msgSignUpAlreadyExist;
    }

    public void setMsgSignUpAlreadyExist(By msgSignUpAlreadyExist) {
        this.msgSignUpAlreadyExist = msgSignUpAlreadyExist;
    }

    public By getBtnContinue() {
        return btnContinue;
    }

    public void setBtnContinue(By btnContinue) {
        this.btnContinue = btnContinue;
    }
}
