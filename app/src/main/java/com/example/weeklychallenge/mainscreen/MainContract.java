package com.example.weeklychallenge.mainscreen;

/**
 * This specifies the contract between the View and the Presenter for {@link MainActivity}.
 */
public interface MainContract {

    /** Interface that should be implemented by the MainActivity. */
    interface View {

        /**
         * Method that shows a Toast when the first button is pressed.
         */
        void showButtonToast();

        /**
         * Method that shows a Dialog when the second button is pressed.
         */
        void showButtonDialog();

        /**
         * Method that loads a new Screen when the third button is pressed.
         */
        void loadNewScreen();

    }

    /**
     * Interface that should be implemented by the MainPresenter.
     */
    interface Presenter {

        /**
         * Method to handle when a button is clicked.
         *
         * @param buttonId The identification of each button.
         */
        void handleButtonClicked(final int buttonId);
    }
}
