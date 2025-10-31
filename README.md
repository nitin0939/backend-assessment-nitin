# String Calculator TDD Kata

A comprehensive implementation of the String Calculator TDD Kata in Java, demonstrating Test-Driven Development principles and incremental feature development.

## 🚀 Features

### ✅ Implemented Features
- **Empty String Handling**: Returns 0 for empty input
- **Single/Multiple Numbers**: Handles 1 to unlimited numbers
- **Multiple Delimiters**: Supports comma `,` and newline `\n`
- **Custom Delimiters**: Format `//;\n1;2;3` with any single character
- **Special Character Delimiters**: Handles regex special chars like `.`, `*`, etc.
- **Negative Number Validation**: Throws exception with all negative numbers listed
- **Large Number Filtering**: Ignores numbers > 1000
- **Multi-Character Delimiters**: Format `//[***]\n1***2***3`
- **Multiple Custom Delimiters**: Format `//[*][%]\n1*2%3`


## 🏗️ Architecture

### Core Components
```
Calculator.java
├── add(String numbers)          # Main calculation method
└── getTokens(String numbers)    # Parses input and extracts numbers
```

### Key Design Patterns
- **Static Methods**: Utility-style calculator
- **Regex Pattern Matching**: Advanced delimiter parsing
- **Exception Handling**: Comprehensive negative number validation
- **Input Sanitization**: Handles edge cases and malformed input

## 📋 Usage Examples

```java
// Basic usage
Calculator.add("");           // Returns: 0
Calculator.add("1");          // Returns: 1
Calculator.add("1,2,3");      // Returns: 6

// Mixed delimiters
Calculator.add("1\n2,3");     // Returns: 6

// Custom delimiters
Calculator.add("//;\n1;2;3"); // Returns: 6
Calculator.add("//[***]\n1***2***3"); // Returns: 6
Calculator.add("//[*][%]\n1*2%3");   // Returns: 6

// Large numbers ignored
Calculator.add("2,1001");     // Returns: 2

// Negative numbers throw exception
Calculator.add("1,-2,-3");    // Throws: "negatives not allowed -2, -3"
```

## 🧪 Testing Strategy

### Test Coverage
- **Empty Input**: Edge case handling
- **Single Numbers**: Basic functionality
- **Multiple Numbers**: Core feature validation
- **Delimiter Variations**: All supported formats
- **Error Scenarios**: Negative numbers, malformed input
- **Performance**: Large number filtering
- **Advanced Features**: Multi-character and multiple delimiters

### TDD Approach
1. **Red**: Write failing test
2. **Green**: Write minimal code to pass
3. **Refactor**: Improve code while keeping tests green
4. **Repeat**: For each new requirement

## 🛠️ Technical Implementation
## 🔧 Build & Run

```bash
# Run tests
./gradlew test

# Build project
./gradlew build

# Clean build
./gradlew clean build
```

## 📊 Project Stats
- **Language**: Java 11
- **Build Tool**: Gradle 5.6.4
- **Testing**: JUnit 5
- **Test Cases**: 12 comprehensive tests
- **Code Coverage**: All major paths covered
- **Performance**: Optimized for readability and maintainability

## 🎯 Learning Outcomes
- Test-Driven Development methodology
- Incremental feature development