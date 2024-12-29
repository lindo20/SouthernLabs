# lindokuhle Dubazane
# partner1: Given Sitole
# partner2: Nkululeko Banda

sports_leagues = {"NFL": "National Football League (American football)",
                  "MLB": "Major League Baseball (Baseball)",
                  "NBA": "National Basketball Association (Basketball)",
                  "EPL": "Premier League (Association football)",
                  "NHL": "National Hockey League (Ice hockey)",
                  "MLS": "Major League Soccer (Association football)",
                  "IPL": "Indian Premier League (Twenty20 cricket)",
                  "AFL": "Australian Football League (Australian rules football)",
                  "NRL": "National Rugby League (Rugby league football)",
                  "CFL": "Canadian Football League (Canadian football)"}


def delete_league():
    """
    This function named delete_league() prompts the user to enter the name (“key”) of a league to be deleted.
    This function will give a message as in the following examples when it is called:
    delete_league("aBc")  # prints “there is no league named aBc”
    delete_league("nHl")  # removes NHL from dictionary and prints “The National Hockey League (Ice hockey) has been
    removed”
    :return: None
    """
    global sports_leagues
    user_key = input("Enter the name ('key') of a league to be deleted: ").upper()

    if user_key in sports_leagues:
        value = sports_leagues.pop(user_key)
        print(f"{value} has been removed.")
    else:
        print(f"There is no league named {user_key}")


def add_league():
    """
    This function prompts the user for a key (the three-letter abbreviation) and the value
    (a full string description of the new league), and adds it to the sports_leagues dictionary. However,
    if that key already exists (e.g. AFL), an error message happens instead,
    printing “AFL is already listed as the Australian Football League (Australian rules football)”.
    :return: None
    """
    user_key = input("Enter  the (three-letter abbreviation) of sport league to be added:").upper()
    user_value = input("Enter the description of the new league:").title()

    if len(user_key) == 3:
        if user_key in sports_leagues:
            print(f"{user_key} is already listed as the {sports_leagues[user_key]}")
        else:
            sports_leagues[user_key] = user_value
            print(f" new  sports_leagues is  added to dictionary {user_key},{user_value}")


def get_abbreviations():
    """
    This function creates a list of all sports_leagues keys.
    :return: list of all sports_leagues keys
    """
    sports_league_abbreviations = []
    for key in sports_leagues.keys():
        sports_league_abbreviations.append(key)
    return sports_league_abbreviations


def get_league_descriptions():
    """
    This function creates a list and convert a list to a tuple of all sports_leagues values.
    :return: a tuple of all sports_leagues values
    """
    league_description = []
    for value in sports_leagues.values():
        league_description.append(value)

    return tuple(league_description)


def get_league_abbreviations_and_descriptions():
    """
    This function creates a set of all sports_leagues keys and values.
    :return: a set of all sports_leagues keys and values
    """
    league_abbreviations_and_descriptions = set()
    for key, value in sports_leagues.items():
        league_abbreviations_and_descriptions.add((key, value))
    return league_abbreviations_and_descriptions


if __name__ == "__main__":
    delete_league()
    add_league()
    print(get_abbreviations())
    print(get_league_descriptions())
    print(get_league_abbreviations_and_descriptions())
