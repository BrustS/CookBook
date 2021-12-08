package by.brust.cookbook.domain.usecases

class LoginUserByEmailUseCase {

    fun execute(email : String, password: String) : Boolean {
        // TODO: Request to  Network
        return email.isNotEmpty() && password.isNotEmpty()
    }
}