$(document).ready(function() {
	$(".add-build-flow-step").on("click", function() {
		console.log("Showing add build flow step dialog...");
	});

	$("#steps").sortable({
		revert: true,
		accept: "#executor",
		receive: showAddBuildFlowModal
	});

	$(".executor").draggable({
		connectToSortable: "#steps",
		helper: "clone"
	}).disableSelection();

});

function showAddBuildFlowModal(event, ui) {
	var buildFlowType = ui.item.data('type');

	console.log("Showing modal for " + buildFlowType);

	var url = "/executor/modal?type=" + buildFlowType;

	// Do ajax to get modal
	//$.ajax({
	//	url: url,
	//	success: showModalWithHtml
	//});

	showModalWithHtml("<div class='modal-header'>" +
			"<button class='close' data-dismiss='modal'>x</button>" +
			"</div>" +
			"<div class='modal-body'>" +
			"Test" +
			"</div>" +
			"<div class='modal-footer'>Close</div>");
}

function showModalWithHtml(data) {
	var modal = $("#executor-modal");
	modal.removeClass("hide");
	modal.empty();
	modal.append(data);
	//modal.attr("hidden", false);
	$("#executor-modal").modal();
}