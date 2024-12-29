# author: Lindokuhle Dubazane
# partner1: Rethabile Sitole
# partner2: Nkululeko Banda
import login


def main():
    first_name = input("Enter your first name:").capitalize()
    last_name = input("Enter your last name:").capitalize()
    bcit_id = input("Enter your BCIT ID :")

    default_password = login.generate_password(first_name, last_name, bcit_id)
    print("your password:", default_password)

    login.change_password()


if __name__ == "__main__":
    main()
