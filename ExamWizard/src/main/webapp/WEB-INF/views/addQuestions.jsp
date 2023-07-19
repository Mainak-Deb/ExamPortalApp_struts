<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Questions</title>
<link rel="stylesheet" href="public/styles/addQuestions.css" />
</head>
<body>
    <div id="header">Exam code:  ${eid} </div>
    <div class="more-qs">
      <a href="./allQuestions">Add from previous questions</a>
    </div>
    <div>
      <form id="mcq-form"  action="submitQuestions.do">
        <input
             
              type="text"
              id="option-a-image"
              name="eid"
              value= "${eid}"
              style="display:none;"
            />
        <div class="question-container">
          <h2 style="text-align: center">ADD QUESTIONS</h2>
          <div class="question-section">
            <label for="question1">Question:</label>
            <textarea
              type="text"
              id="question1"
              name="q_text"
              placeholder="Enter the question"
              oninput="autoResizeTextarea(this)"
              required
            ></textarea>
            <input
              class="file-input"
              type="file"
              id="option_a_image"
              name="q-image"
              onchange="handleFileInputChange(this)"
            />
            <!-- <img id="preview-image" class="preview-image" src="" alt="Preview Image" /> -->
          </div>

          <div class="option-section">
            <div class="option">
              <label for="option-a">
              	<div class="round-option">A</div>
              </label>
              <input
                type="text"
                class="option-input"
                id="option-a-text"
                name="option_a_text"
                placeholder="Enter option A"
                required
              />
              <input
                class="file-input"
                type="file"
                id="option-a-image"
                name="option_a_image"
                onchange="handleFileInputChange(this)"
              />
            </div>

            <div class="option">
              <label for="option-b"><div class="round-option">B</div></label>
              <input
                type="text"
                class="option-input"
                id="option-b-text"
                name="option_b_text"
                placeholder="Enter option B"
                required
              />
              <input
                class="file-input"
                type="file"
                id="option-b-image"
                name="option_b_image"
                onchange="handleFileInputChange(this)"
              />
            </div>

            <div class="option">
              <label for="option-c"><div class="round-option">C</div></label>
              <input
                type="text"
                class="option-input"
                id="option-c-text"
                name="option_c_text"
                placeholder="Enter option C"
                required
              />
              <input
                class="file-input"
                type="file"
                id="option-c-image"
                name="option_c_image"
                onchange="handleFileInputChange(this)"
              />
            </div>

            <div class="option">
              <label for="option-d"><div class="round-option">D</div></label>
              <input
                type="text"
                class="option-input"
                id="option-d-text"
                name="option_d_text"
                placeholder="Enter option D"
                required
              />
              <input
                class="file-input"
                type="file"
                id="option-d-image"
                name="option_d_image"
                onchange="handleFileInputChange(this)"
              />
            </div>
          </div>
          <div class="correct-option">
            <label for="answer">Correct answer</label>
            <select class="custom-select" name="answer" id="answer">
              <option value="a">Option A</option>
              <option value="b">Option B</option>
              <option value="c">Option C</option>
              <option value="d">Option D</option>
            </select>
          </div>
          <div class="correct-option">
            <label for="answer">Question marks</label>
            <select class="custom-select" name="marks" id="answer">
              <option value="1" >1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
          </div>
          <div style="display: flex; justify-content: center; margin-top: 20px">
            <button class="add-qs-button" type="submit" class="submit-btn">
              Add Questions
            </button>
          </div>
        </div>
      </form>
    </div>
</body>
</html>