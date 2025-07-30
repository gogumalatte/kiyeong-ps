#include <iostream>
#include <string>
#include <map>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    std::map<std::string, std::string> translations;

    translations["CU"] = "see you";
    translations[":-)"] = "I’m happy";
    translations[":-("] = "I’m unhappy";
    translations[";-)"] = "wink";
    translations[":-P"] = "stick out my tongue";
    translations["(~.~)"] = "sleepy";
    translations["TA"] = "totally awesome";
    translations["CCC"] = "Canadian Computing Competition";
    translations["CUZ"] = "because";
    translations["TY"] = "thank-you";
    translations["YW"] = "you’re welcome";
    translations["TTYL"] = "talk to you later";

    std::string input_text;

    while (true) {
        std::cin >> input_text;

        if (translations.count(input_text)) {
            std::cout << translations[input_text] << std::endl;
        } else {
            std::cout << input_text << std::endl;
        }

        if (input_text == "TTYL") {
            break;
        }
    }

    return 0;
}
