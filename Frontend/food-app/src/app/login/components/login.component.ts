// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrl: './login.component.css'
// })
// export class LoginComponent {

// }

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  registerForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {
    // Initialize the form with form controls and validators
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],  // Name is required
      email: ['', [Validators.required, Validators.email]],  // Email must be valid
      password: ['', [Validators.required, Validators.minLength(6)]]  // Password must be at least 6 characters
    });
  }

  // Getter to access form controls
  get f() {
    return this.registerForm.controls;
  }

  // Handle form submission
  onSubmit() {
    this.submitted = true;  // Set the submitted flag to true

    // Stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    // Handle form submission logic (e.g., send data to a server)
    console.log('Form Data:', this.registerForm.value);
    alert('Registration successful!');
  }
}

