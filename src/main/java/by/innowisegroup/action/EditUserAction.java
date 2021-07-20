package by.innowisegroup.action;

import by.innowisegroup.IO.Input;
import by.innowisegroup.model.Role;
import by.innowisegroup.model.User;
import by.innowisegroup.store.Store;

public class EditUserAction implements Action {

    private static final String EMAIL_PATTERN = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
    private static final String PHONE_PATTERN = "375\\s\\d{2}\\s\\d{7}";

    @Override
    public String name() {
        return "=== Edit User ===";
    }

    @Override
    public boolean execute(Input input, Store memStore) {
        memStore.findAll().forEach(System.out::println);
        Integer id = input.askInt("select ID of user which you want to edit: ");
        User user = memStore.findById(id);

        editNameField(input, user);
        System.out.println();
        editSurnameField(input, user);
        System.out.println();
        editEmailField(input, user);
        System.out.println();
        editPhoneField(input, user);
        System.out.println();
        addPhoneField(input, user);
        System.out.println();
        editRoleField(input, user);
        System.out.println();
        System.out.println(user);
        memStore.replace(user);
        return true;
    }

    private void editNameField(Input input, User user) {
        String name = input.askStr("Old name: " + user.getName() + ". If you want to keep the old name, press \"ENTER\"");
        if (isEdit(name)) {
            user.setName(name);
        }
    }

    private void editSurnameField(Input input, User user) {
        String surname = input.askStr("Old surname: " + user.getSurname() + ". If you want to keep the old surname, press \"ENTER\"");
        if (isEdit(surname)) {
            user.setSurname(surname);
        }
    }

    private void editEmailField(Input input, User user) {
        String checkEmail = input.askStr("If you want to keep the old email, press \"ENTER\". If you want to change email, press any key");
        if (isEdit(checkEmail)) {
            String email = input.askWithPattern("Old email: " + user.getEmail() + ". Enter email.", EMAIL_PATTERN);
            user.setEmail(email);
        }
    }

    private void editPhoneField(Input input, User user) {
        boolean flag;
        do {
            System.out.println("You have the following saved phones: ");
            for (int i = 0; i < user.getPhones().size(); i++) {
                System.out.println(i + 1 + ". " + user.getPhones().get(i));
            }
            System.out.println();

            String checkPhone = input.askStr("If you want to keep the old phone, press \"ENTER\". If you want to change phone, press any key");
            flag = isEdit(checkPhone);
            if (flag) {
                int number = input.askInt("Select the number to change.", user.getPhones().size());
                String phone = input.askWithPattern("Enter phone like 375 ** *******: ", PHONE_PATTERN);

                user.getPhones().set(number - 1, phone);
            }
        } while (flag);

    }

    private void addPhoneField(Input input, User user) {
        boolean flag = false;
        do {
            if (user.getPhones().size() < 3) {
                String checkAddPhone = input.askStr("If you want add phone press any key, else press \"ENTER\"");
                flag = isEdit(checkAddPhone);
                if (flag) {
                    String phone = input.askWithPattern("Enter phone like 375 ** *******: ", PHONE_PATTERN);
                    user.getPhones().add(phone);
                }
            }
        } while (flag);
    }

    private void editRoleField(Input input, User user) {
        System.out.println("Role is");
        user.getRoles().forEach(System.out::println);
        String checkRole = input.askStr("If you want to keep the old ROLE, press \"ENTER\". If you want to change ROLE, press any key");
        if (isEdit(checkRole)) {
            user.getRoles().clear();
            System.out.println("Please choose new ROLE");
            setRole(input, user);
        }
    }

    private boolean isEdit(String conditions) {
        return !conditions.equals("");
    }
}
