package com.study.kokhrimenko.algoriths.external.oracle.jdk8;
public class DevGymException {

    private static IllegalArgumentException illegalArgument;

    public static void main(String... doYourBest) {
        try {
            double exceptionNumber = 2 / 0.0;
            System.out.println("exceptionNumber");

            throw illegalArgument;
        } catch (NullPointerException nullPointer) {
            System.out.println("NullPointer");
        } catch (IllegalArgumentException illegalArgument) {
            System.out.println("IllegalArgument");
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("Finally");
        }
    }

}