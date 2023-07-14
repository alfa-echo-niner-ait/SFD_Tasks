import sys
import requests
import json
import LOGGER   # Self Defined Module

class DataReader:
    # API URL
    URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    # Store dict() data from the fetched data
    DATA = dict()

    def __init__(self, word):
        self.word = word
        self.URL = self.URL + word

        try:
            # Fetch data
            rawData = requests.get(self.URL).text
        except:
            # Exit if failed
            warn = LOGGER.Logger('<class>DataReader')
            warn.warning("Data fetching failed! Please check network.")
            print("Data fetching failed! Please check network.")
            sys.exit()

        # Fetched data type <list>
        loadedData = json.loads(rawData)

        if type(loadedData) == type(dict()):
            error = LOGGER.Logger('<class>DataReader')
            error.error("Word not found!")
            print("Sorry, word not found!")
            sys.exit()
        else:
            # First item of the <list> is the actual data as <dict>
            self.DATA = loadedData[0]


class DictReader(DataReader):
    # Phonetic (if have), otherwise empty
    phonetic = ''
    # All the definition(s) of a word
    definitions = list()

    def __init__(self, word):
        super().__init__(word)
        # Filter information from dict() DATA
        try:
            self.phonetic = self.DATA['phonetics'][1]['text']
        except:
            pass

        for meaning in self.DATA['meanings']:
            for defintion in meaning['definitions']:
                self.definitions.append(defintion['definition'])

    def getPhonetic(self):
        return self.phonetic

    def getDefinitions(self):
        return self.definitions


def validWord(word):
    invalid_ch = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ']
    for ch in word:
        for num in invalid_ch:
            if ch == num:
                return True


def main(argWord):
    inf = LOGGER.Logger('<method>main')
    inf.info(f"Searching word: {argWord}")

    # Check for valid words or exit
    if validWord(argWord):
        er = LOGGER.Logger('<method>validWord')
        er.error("Invalid word! Please pass correct word.")
        print("Invalid word! Please pass correct word.")
        sys.exit()

    myDictData = DictReader(argWord)

    print("\n---------------------------------------")
    print(f"{myDictData.word} {myDictData.getPhonetic()}")
    print("---------------------------------------")
    print("Definitions:")
    for defi in myDictData.getDefinitions():
        print(f"[>>] {defi}")
    print("---------------------------------------\n")

    inf.info(f"Result print success: {argWord}")


main(sys.argv[1])